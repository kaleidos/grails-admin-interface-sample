import conferences.*

class BootStrap {
    def init = { servletContext ->
        log.debug "INICIANDO"

        def role = Role.findByAuthority("ROLE_ADMIN")
        if (!role) {
            role = new Role(authority: "ROLE_ADMIN").save()
        }

        def user = User.findByUsername("admin")
        if (!user) {
            user = new User(username:"admin", password:"admin").save()
        }

        def userRole = UserRole.findByUserAndRole(user, role)
        if (!userRole) {
            new UserRole(user:user, role:role).save()
        }

        def conference = new Conference(name:'Conference 1', startDate: Date.parse("dd/MM/yyyy", "05/05/2015"), endDate: Date.parse("dd/MM/yyyy", "06/05/2015"))
        conference.save()



        def building1 = new Building(name:"Building1")
        building1.save()
        def building2 = new Building(name:"Building2")
        building2.save()



        (1..10).each {

            new Attendee(name:"Attendee$it").save()
            def building = building1
            if (it%2) {
                building = building2
            }
            def room = new Room(name:"Room$it", photo:new File("/tmp/photo.jpg"), building:building)
            room.save()
            def speaker = new Speaker(name:"Speaker$it", birthDate:Date.parse("dd/MM/yyyy", "01/01/1970"))
            speaker.save()
            speaker.addToConferences(conference)
            new Talk(name:"Talk$it", talkDate:Date.parse("dd/MM/yyyy", "05/05/2015"), talkTime:"12:00", speaker:speaker, room:room).save()

        }


    }

    def destroy = {
        log.debug "PARANDO"
    }
}
