package sample

import net.kaleidos.plugins.admin.widget.Widget

class MapWidget extends Widget {

    String render() {
        def html = new StringBuilder()
        html.append("<div class='map-widget'>")
        html.append("<div>")
        html.append("<span class='map-container'>")
        html.append("<iframe width='${internalAttrs.width?:425}' height='${internalAttrs.height?:350}' frameborder='0' scrolling='no' marginheight='0' marginwidth='0'")
        html.append("src='https://maps.google.com/maps?f=q&amp;q=${value}&amp;output=embed'")
        html.append("></iframe>")
        html.append("</span>")
        html.append("<input type='button' class='map-widget-refresh js-map-widget-refresh' value='Refresh' />")
        html.append("</div>")

        html.append("<div>")

        html.append("<input type='text' class='form-control map-widget-text js-map-widget-text' ")
        htmlAttrs.each{key, value ->
            html.append("$key='${value}' ")
        }
        html.append("value='${value}' />")
        html.append("</div>")
        html.append("</div>")
        return html
    }

    List<String> getAssets() {
        [ 'js/admin/map.js',
          'css/admin/map.css'
        ]
    }
}
