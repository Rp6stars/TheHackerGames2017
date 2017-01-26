(function (window, document, $) {

  $(document).ready(function () {
    $('.js-trafficlight-widget').each(function () {
      generateTrafficlightWidget($(this));
    });
    initRadioHandler();
    initStep1();
  });

  function initRadioHandler() {
    $('body').on('change', 'input[type="radio"]', function (ev) {
      $this = $(this);
      $siblings = $this.closest('.js-trafficlight-widget').find('label');
      $siblings.removeClass('selected');
      $this.closest('label').addClass('selected')
    });
  }

  function initStep1() {
    $('.js-left-hand-thumb').hide();
    $('.js-left-hand-fingers').hide();
    $('.js-right-hand-thumb').hide();
    $('.js-right-hand-fingers').hide();

    handleHandChange('left');
    handleHandChange('right');
  }

  function handleHandChange(hand) {
    $('.js-' + hand + '-hand').on('change', 'input[type="radio"]', function (ev) {
      $this = $(this);
      console.log(hand, $this.val());

      var $fingers = $('.js-' + hand + '-hand-fingers');
      var $thumb = $('.js-' + hand + '-hand-thumb');

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
  $siblings = $el.closest('.js-trafficlight-widget').find('label');
  $siblings.removeClass('selected');
}

  function generateTrafficlightWidget($selector) {
    var name = $selector.data('name');
    var rand = new Date().getTime();

    var spacelessName = name.replace(/\s/g,'')

    var widget = '<div class="trafficlight-widget js-trafficlight-widget">\
      <label class="trafficlight-widget_item trafficlight-widget_item--good" for="' + spacelessName + '_good_' + rand + '"><input id="' + spacelessName + '_good_' + rand + '" type="radio" name="' + name + '" value="1"> Good</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--some" for="' + spacelessName + '_some_' + rand + '"><input id="' + spacelessName + '_some_' + rand + '" type="radio" name="' + name + '" value="2"> Some</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--none" for="' + spacelessName + '_none_' + rand + '"><input id="' + spacelessName + '_none_' + rand + '" type="radio" name="' + name + '" value="3"> None</label>\
    </div>';

    $selector.append(widget);
  }

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

}(window, document, jQuery))

$(document).ready(function () {
  $('.js-submit-step-1').on('click', function (ev) {
    ev.preventDefault();
    $this = $(this);
    $form = $this.closest('form');
    console.log(JSON.stringify($form.serializeArray()));

    var promise = $.ajax({
      beforeSend: function(xhrObj){
        xhrObj.setRequestHeader("Content-Type","application/json");
        xhrObj.setRequestHeader("Accept","application/json");
      },
      method: "POST",
      url: "/api/getSuggestions",
      data: JSON.stringify($form.serializeArray())
    });

    promise.done(function (response) {
      console.log(response);
    });

    promise.fail(function (a,b) {
      console.log("fail", a, b);
    });
  })
});
