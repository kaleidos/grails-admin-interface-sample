package conferences

class ConferenceAdmin {
    static options = {
        list excludes: ['speakers', 'talks']
        create excludes: ['speakers', 'talks']
        edit includes: ['name', 'startDate', 'endDate', 'address', 'speakers', 'talks']
        widget "name", help:"The name of the conference"
        widget "address", "sample.MapWidget", width: 500, height: 100
        groups {
            "Dates" style:"collapse", fields: [ 'startDate', 'endDate' ]
        }
    }
}
