class UrlMappings {

    static mappings = {
        name "login": "/login/auth" {controller="login"; action="auth"}
        name "loginDenied": "/login/denied" {controller="login"; action="denied"}

        "/" (view:'/index')
        "500"(view:'/error')
    }
}
