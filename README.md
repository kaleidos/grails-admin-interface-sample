grails-admin-interface-sample
=============================

Sample project for the Grails Admin Interface Plugin


This project uses Grails Admin Interface Plugin to manage several domain classes:

- Conference
- Talk
- Attendee
- Speaker
- Building
- Room



## Configuration

Let's see several interesting facts on Config.groovy

### Set Admin URL
The admin url will be /myadmin

```
def base = "myadmin"
grails.plugin.admin.accessRoot = "/$base"
```


### Set Basic Auth security for API access
We want to use Basic Auth for expose our admin API

```
grails.plugin.springsecurity.filterChain.chainMap = [
   "/$base/api/**": 'JOINED_FILTERS,-exceptionTranslationFilter',
   '/**': 'JOINED_FILTERS,-basicAuthenticationFilter,-basicExceptionTranslationFilter'
]
```


### Properties groups 
The diferent domains are grouped on three groups.

```
grails.plugin.admin.domains."Conference Management" = [
    "conferences.Conference",
    "conferences.Talk"
]

grails.plugin.admin.domains."People" = [
    "conferences.Attendee",
    "conferences.Speaker"
]

grails.plugin.admin.domains."Infrastructures" = [
    "conferences.Building",
    "conferences.Room"
]
```

### Includes and excludes properties
When we are listing the attendees, we want to display only the field 'name'.
When we create a new attendee, we don't want to display the field 'comment'.
When we edit an attendee, we want to display 'name', 'country' and 'comment on that order.

```
grails.plugin.admin.domain.Attendee = {
    list includes: ['name']
    create excludes: ['comment']
    edit includes: ['name', 'country', 'comment']
}
```

### Extra properties: help text
Show a help text on the 'board' field of a Room.

```
grails.plugin.admin.domain.Room = {
    widget "board", help:"Does the room has a whiteboard?"
}
```


### Use an external config class
We define that the configuration for Conference will be on a class named conferences.ConferenceAdmin

```
grails.plugin.admin.domain.Conference = "conferences.ConferenceAdmin"
```
