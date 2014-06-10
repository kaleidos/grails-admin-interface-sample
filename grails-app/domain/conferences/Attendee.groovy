package conferences

class Attendee {
    String name
    String comment
    String country

    static constraints = {
        name nullable:false, blank: false
        comment nullable:true, blank: true
        country nullable:true, blank: true
    }
}
