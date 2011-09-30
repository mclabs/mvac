if (window._sbdOptions_DetectJSErrors) {
    (function() {
      var rolled_up_errors = [];
      var timer;
      window.onerror = function(message, script_url, line_number) {
          try {
              if (Scribd.rails_env == 'test') {
                if (!Scribd.javascript_errors)
                  Scribd.javascript_errors = '';
                else
                  Scribd.javascript_errors += '\n\n';
                Scribd.javascript_errors += 'URL: ' + script_url + '\nLine: ' + line_number + '\nMessage: ' + message;
              } else {
                if (timer != undefined)
                  clearTimeout(timer);

                var index = rolled_up_errors.length;
                var body_tag = document.getElementsByTagName('body')[0];      
                var body_class_names = '', controller = '', action = '', rev = '';

                if (body_tag) {
                    body_class_names = body_tag.className.split(' ').sort();
                    controller = body_class_names[0].substring(4); // get rid of loc_
                    action = body_class_names[1].substring(body_class_names[0].length + 1); // remove prefix & underscore to get action
                    rev = body_tag.getAttribute('data-revision');
                }

                rolled_up_errors.push(encodeURI('errors[' + index + '][page_url]=') + encodeURIComponent(window.location.href)
                                      + encodeURI('&errors[' + index + '][message]=') + encodeURIComponent(message)
                                      + encodeURI('&errors[' + index + '][script_url]=') + encodeURIComponent(script_url)
                                      + encodeURI('&errors[' + index + '][line_number]=') + encodeURIComponent(line_number)
                                      + encodeURI('&errors[' + index + '][controller]=') + encodeURIComponent(controller)
                                      + encodeURI('&errors[' + index + '][action]=') + encodeURIComponent(action)
                                      + encodeURI('&errors[' + index + '][rev]=') + encodeURIComponent(rev));

                timer = setTimeout(function() {
                  try { new Ajax.Request('/javascript_errors', { parameters: rolled_up_errors.join('&') }); }
                  catch (e) {}
                  rolled_up_errors = [];
                  timer = undefined;
                }, 1000);
              }

          } catch (e) { }
      }
    })();
}
