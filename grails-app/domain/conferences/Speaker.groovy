package conferences

class Speaker {

    static hasMany=[talks:Talk, conferences:Conference]
    static belongsTo = Conference
    String name
    Date birthDate
    SpeakerGender gender = SpeakerGender.FEMALE


    static constraints = {
        gender nullable:true
    }

    String toString(){
        return name
    }
}

enum SpeakerGender {
    MALE, FEMALE
}
