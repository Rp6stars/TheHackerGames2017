// Interface handlers
(function (window, document, $) {

  $(document).ready(function () {
    $('.js-trafficlight-widget').each(function () {
      generateTrafficlightWidget($(this));
    });
    initRadioHandler();
    initPlatformsHandler();
    initStep1();
  });

  function initRadioHandler() {
    $('body').on('change', 'input[type="radio"]', function (ev) {
      $this = $(this);
      $siblings = $this.closest('.js-radio-widget').find('label');
      $siblings.removeClass('selected');
      $this.closest('label').addClass('selected')
    });
  }

  function initPlatformsHandler() {
    $('.js-platforms').on('click', '.js-platforms-item', function (ev) {
      $this = $(this);
      if ($this.find('input[type="checkbox"]').prop('checked') === true ) {
          $this.addClass('active');
      } else {
        $this.removeClass('active');
      }

    });
  }

  function initStep1() {
    handleHandChange('left');
    handleHandChange('right');
    initRobotHover();
  }

  function handleHandChange(hand) {

    var $fingers = $('.js-' + hand + '-hand-fingers');
    var $thumb = $('.js-' + hand + '-hand-thumb');

    $thumb.hide();
    $fingers.hide();


    $('.js-' + hand + '-hand').on('change', 'input[type="radio"]', function (ev) {
      $this = $(this);
      console.log(hand, $this.val());

      if ($this.val() > 1) {

        $thumb.slideDown();
        $fingers.slideDown();

      } else {

        $thumb.slideUp(150);
        $fingers.slideUp(150);

        uncheckRadio($thumb.find('input[type="radio"]:checked'));
        uncheckRadio($fingers.find('input[type="radio"]:checked'));
      }
    });
  }

  function uncheckRadio($el) {
    $el.prop('checked', false);
    var $siblings = $el.closest('.js-trafficlight-widget').find('label');
    $siblings.removeClass('selected');
  }

  function generateTrafficlightWidget($selector) {
    var name = $selector.data('name');
    var rand = new Date().getTime();

    var spacelessName = name.replace(/\s/g,'')

    var widget = '<div class="trafficlight-widget js-trafficlight-widget js-radio-widget">\
      <label class="trafficlight-widget_item trafficlight-widget_item--good" for="' + spacelessName + '_good_' + rand + '"><input id="' + spacelessName + '_good_' + rand + '" type="radio" name="' + name + '" value="1"> Good</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--some" for="' + spacelessName + '_some_' + rand + '"><input id="' + spacelessName + '_some_' + rand + '" type="radio" name="' + name + '" value="2"> Some</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--none" for="' + spacelessName + '_none_' + rand + '"><input id="' + spacelessName + '_none_' + rand + '" type="radio" name="' + name + '" value="3"> None</label>\
    </div>';

    $selector.append(widget);
  }

  function initRobotHover(){
    $('.js-svg-hover-trigger').on('mouseenter', function () {
      var elName = $(this).data('svg-el');
      var $tar = $('#' + elName);
      if ($tar instanceof jQuery) {
        $tar.attr('class', 'pulse-svg')
      }
    });
    $('.js-svg-hover-trigger').on('mouseleave', function () {
      var elName = $(this).data('svg-el');
      var $tar = $('#' + elName);
      if ($tar instanceof jQuery) {
        $tar.attr('class', '')
      }
    });

  }


}(window, document, jQuery));

//Eyes
(function (window, document, $) {
  $(document).ready(function () {
    var $leftPupil = getPupulElement();
    var $rightPupil = getPupulElement();

    $('.js-eye-left').append($leftPupil);
    $('.js-eye-right').append($rightPupil);

    $(document).mousemove(function(e){
      moveEyePupil($leftPupil, e.pageX - window.pageXOffset, e.pageY - window.pageYOffset);
      moveEyePupil($rightPupil, e.pageX - window.pageXOffset, e.pageY - window.pageYOffset);
    });

    function getPupulElement() {
      return $('<div class="face_eye_pupil"></div>');
    }

    function moveEyePupil($element, cursorX, cursorY) {
      // console.log(cursorX, cursorY);
      var newTop, newLeft;
      var pupilDiameter= $element.width(); //Assume the pupil is perfect circle
      var parentOffset = $element.parent()[0].getBoundingClientRect();
      var parentHeight = $element.parent().height();

      // console.log("parentOffset", parentOffset.top);

      function getOffset (cursor, side) {
        if (cursor <= parentOffset[side]) {
          return 0;
        } else if (cursor > parentOffset[side] - pupilDiameter && cursor  <= parentOffset[side] + parentHeight - pupilDiameter) {
          return cursor - parentOffset[side];
        } else {
          return parentHeight - pupilDiameter;
        }
      }

      $element.css({
        'top': getOffset(cursorY, 'top')+ 'px',
        'left': getOffset(cursorX, 'left')+ 'px',
      });
    }
  });
}(window, document, jQuery));

// Submit and step 2
(function (window, document, $) {

  var formData = [];

  $(document).ready(function () {
    $('.js-submit-step-1').on('click', function (ev) {
      ev.preventDefault();
      $this = $(this);
      $form = $this.closest('form');
      formData = $form.serializeArray();
      // console.log(JSON.stringify(formData));

      $this.addClass('loading');

      if (formData.length < 1) {
        $this.removeClass('loading');
        return;
      }

      var promise = $.ajax({
        beforeSend: function(xhrObj){
          xhrObj.setRequestHeader("Content-Type","application/json");
          xhrObj.setRequestHeader("Accept","application/json");
        },

        method: "POST",
        url: "/api/getSuggestions", //Proxypassed though apache to avoid cors

        // Test data
        // method: "GET",
        // url: "mock.json",

        data: JSON.stringify(formData)
      });

      promise.done(function (response) {
        $('#render-area').load('partials/page2.html', function () {
          window.scrollTo(0, 0);
          buildMastheadList();
          $('#featured-products-area').html(returnGadgetList(response.gadgetSet));
          $('.js-video-list-small').html(returnVideoList(response.videoSet));
          $('#featured-video-area').html(returnFeaturedVideo(response.videoSet[0]));
        });
      });

      promise.fail(function (a,b) {
        console.log("fail", a, b);
        $this.removeClass('loading');
      });
    })
  });

  function buildMastheadList() {
    var goodList = '';
    var someList = '';
    formData.forEach(function callback(currentValue, index, array) {
      switch (parseInt(currentValue.value)) {
        case 1:
          goodList += '<li>' + currentValue.name + '</li>';
          break;
        case 2:
          someList += '<li>' + currentValue.name + '</li>';
          break;
      }
    });

    if (goodList != '') {
      $('.js-masthead-good-list').html(goodList);
    } else {
      $('.js-masthead-good-list-title').hide();
      $('.js-masthead-good-list').hide();
    }

    if (someList != '') {
      $('.js-masthead-some-list').html(someList);
    } else {
      $('.js-masthead-some-list-title').hide();
      $('.js-masthead-some-list').hide();
    }
  }

  function returnFeaturedVideo(videoListItem) {
    return '<h2 class="padded-bottom-double">' + videoListItem.gamerName + ' is a match for your abilities, here’s how we helped</h2>\
      <div class="grid grid--flush background-color-dark-blue">\
        <div class="col-small-7 padded-none"><iframe class="video-large-iframe" src="https://www.youtube.com/embed/' + videoListItem.youtubeId + '?autoplay=0&amp;rel=0&amp;showinfo=0&amp;fs=1&amp;modestbranding=1" frameborder="0" allowfullscreen=""></iframe></div>\
        <div class="col-small-5 text-color-white padded-double padded-top-quad">\<p>' + videoListItem.videoBlurb + '</p></div>\
      </div> <!-- end grid -->';
  }

  function returnVideoList(videoList) {
    var returnString = '';

    $.each(videoList, function(index, value) {
      if (index > 3) {
        return false;
      }
      if (index != 0) {
        returnString += returnVideoListItem(value);
      }
    });

    return returnString;
  }

  function returnVideoListItem(videoListItem) {
    return '<div class="col-small-4">\
      <div class="videos-large-thumb videos-large-thumb--small" style="background-image: url(\'//img.youtube.com/vi/' + videoListItem.youtubeId + '/0.jpg\');"></div>\
        <p>'+ videoListItem.gamerName + '</p>\
      </div>';
  }

  function returnGadgetList(gadgetList) {
    return returnGadgetListItem(gadgetList[0]) + returnGadgetListItem(gadgetList[1]);
  }

  function returnGadgetListItem(gadgetListItem) {
    return '<div class="col-small-6">\
        <div class="gadget-card" style="background-image: url(\'' + gadgetListItem.pictureUrl + '\');">\
          <div class="gadget-card_title">' + gadgetListItem.name + '</div>\
        </div>\
        <p>' + gadgetListItem.description + '</p>\
      </div>';
  }

}(window, document, jQuery));
