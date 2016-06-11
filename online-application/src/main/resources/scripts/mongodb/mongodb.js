db = connect("localhost:27017/sales-order-system")

db.adminCommand('listDatatbases')

printjson(db.getCollectionNames())

db.customers.insert({
    firstname : 'firstname1',
    lastname : 'lastname1',
    dob : '2000-12-21 00:00:00',
    email : 'firstname1.lastname1@email.com',
    address : [
        { flathouseno : 50, street: "Rodney Street", city : "London", country : "UK", postcode : "HD4 5HB" }
    ]
})

db.customers.insert({
    firstname : 'firstname2',
    lastname : 'lastname2',
    dob : '2000-12-21 00:00:00',
    email : 'firstname2.lastname2@email.com',
    address : [
        { flathouseno : 23, street: "Albert Square", city : "Manchester", country : "UK", postcode : "SO24 9NF" }
    ]
})

db.customers.insert({
    firstname : 'firstname3',
    lastname : 'lastname3',
    dob : '2000-12-21 00:00:00',
    email : 'firstname3.lastname3@email.com',
    address : [
        { flathouseno : 556, street: "Tomson Road", city : "Leeds", country : "England", postcode : "SA15 5NW" }
    ]
})

db.customers.insert({
    firstname : 'firstname4',
    lastname : 'lastname4',
    dob : '2000-12-21 00:00:00',
    email : 'firstname4.lastname4@email.com',
    address : [
        { flathouseno : 128, street: "Milestone Alley", city : "Birmingham", country : "England", postcode : "DL8 3AR" }
    ]
})

db.customers.insert({
    firstname : 'firstname5',
    lastname : 'lastname5',
    dob : '2000-12-21 00:00:00',
    email : 'firstname5.lastname5@email.com',
    address : [
        { flathouseno : 16, street: "Cheap Lane", city : "Glasgow", country : "England", postcode : "LL63 5EY" }
    ]
})

db.customers.insert({
    firstname : 'firstname6',
    lastname : 'lastname6',
    dob : '2000-12-21 00:00:00',
    email : 'firstname6.lastname6@email.com',
    address : [
        { flathouseno : 8, street: "Fife Crescent", city : "Newcastle", country : "UK", postcode : "WS4 1LP" }
    ]
})

db.customers.insert({
    firstname : 'firstname7',
    lastname : 'lastname7',
    dob : '2000-12-21 00:00:00',
    email : 'firstname7.lastname7@email.com',
    address : [
        { flathouseno : 3972, street: "Winston Park", city : "Cardiff", country : "UK", postcode : "LL28 5BG" }
    ]
})

db.customers.insert({
    firstname : 'firstname8',
    lastname : 'lastname8',
    dob : '2000-12-21 00:00:00',
    email : 'firstname8.lastname8@email.com',
    address : [
        { flathouseno : 1, street: "Victoria Place", city : "Edinburgh", country : "UK", postcode : "G32 0LG" }
    ]
})

db.customers.insert({
    firstname : 'firstname9',
    lastname : 'lastname9',
    dob : '2000-12-21 00:00:00',
    email : 'firstname9.lastname9@email.com',
    address : [
        { flathouseno : 12, street: "Storm Gate", city : "Derby", country : "UK", postcode : "SK13 2BA" }
    ]
})

db.customers.insert({
    firstname : 'firstname10',
    lastname : 'lastname10',
    dob : '2000-12-21 00:00:00',
    email : 'firstname10.lastname10@email.com',
    address : [
        { flathouseno : 32, street: "Hung Row", city : "Sheffield", country : "UK", postcode : "PL32 9QG" }
    ]
})
