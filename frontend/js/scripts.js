(function (window, document, $) {

  $(document).ready(function () {
    $('.js-trafficlight-widget').each(function () {
      generateTrafficlightWidget($(this));
    });
    initRadioHandler();
  });

  function initRadioHandler() {
    $('body').on('change', 'input[type="radio"]', function (ev) {
      $this = $(this);
      $siblings = $this.closest('.js-trafficlight-widget').find('label');
      $siblings.removeClass('selected');
      $this.closest('label').addClass('selected')
    });
  }

  function generateTrafficlightWidget($selector) {
    var name = $selector.data('name');
    var rand = new Date().getTime();

    var widget = '<div class="trafficlight-widget js-trafficlight-widget">\
      <label class="trafficlight-widget_item trafficlight-widget_item--good" for="' + name + '_good_' + rand + '"><input id="' + name + '_good_' + rand + '" type="radio" name="' + name + '" value="good"> Good</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--some" for="' + name + '_some_' + rand + '"><input id="' + name + '_some_' + rand + '" type="radio" name="' + name + '" value="some"> Some</label>\
      <label class="trafficlight-widget_item trafficlight-widget_item--none" for="' + name + '_none_' + rand + '"><input id="' + name + '_none_' + rand + '" type="radio" name="' + name + '" value="none"> None</label>\
    </div>';

    $selector.append(widget);
  }

}(window, document, jQuery))
