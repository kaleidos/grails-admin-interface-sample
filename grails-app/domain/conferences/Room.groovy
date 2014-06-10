package conferences

class Room {
    String name
    Integer roomNumber
    File photo
    Boolean board = false
    static hasMany=[talk:Talk]

    Building building

    static constraints = {
        photo nullable:true
        roomNumber nullable:true
        building nullable:false
        name validator: {val,obj->
            if (val.startsWith("A")) {
                return false
            }
            return true
        }
    }

    String toString(){
        return name
    }
}
