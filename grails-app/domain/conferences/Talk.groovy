package conferences

class Talk {

    String name
    Date talkDate
    String talkTime
    static belongsTo = [speaker:Speaker]

    Room room


    static constraints = {
        room nullable:true
        speaker nullable:true
    }

    String toString(){
        return name
    }
}
