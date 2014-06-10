package conferences

class Building {
    String name
    static hasMany=[room:Room]

    String toString(){
        return name
    }
}
