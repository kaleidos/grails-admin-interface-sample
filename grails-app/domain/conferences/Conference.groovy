package conferences

class Conference {
    String name
    Date startDate
    Date endDate
    String address

    static hasMany=[talks:Talk, speakers:Speaker]

    static constraints = {
        address nullable:true, blank: true
    }
}
