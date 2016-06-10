db = connect("localhost:27017/sales-order-system")

db.adminCommand('listDatatbases')

printjson(db.getCollectionNames())

db.customers.insert({
    firstname : 'firstname',
    lastname : 'lastname',
    dob : '2000-12-21 00:00:00',
    email : 'firstname.lastname@email.com'
})
