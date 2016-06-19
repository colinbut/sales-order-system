db = connect("localhost:27017/sales-order-system")

db.adminCommand('listDatatbases')

printjson(db.getCollectionNames())

db.orders.drop()
db.items.drop()
db.customers.drop()

db.createCollection("items")
db.createCollection("customers")
db.createCollection("orders")

itemId1 = ObjectId()
itemId2 = ObjectId()
itemId3 = ObjectId()
itemId4 = ObjectId()
itemId5 = ObjectId()
itemId6 = ObjectId()
itemId7 = ObjectId()


db.items.insertMany([
    {_id : itemId1, itemName : 'test-items1', itemPrice : 23.2},
    {_id : itemId2, itemName : 'test-items2', itemPrice : 25.2},
    {_id : itemId3, itemName : 'test-items3', itemPrice : 12.2},
    {_id : itemId4, itemName : 'test-items4', itemPrice : 67.2},
    {_id : itemId5, itemName : 'test-items5', itemPrice : 34.2},
    {_id : itemId6, itemName : 'test-items6', itemPrice : 09.2},
    {_id : itemId7, itemName : 'test-items7', itemPrice : 18.2}
])

db.customers.insertMany([
    {
        firstname : 'firstname1',
        lastname : 'lastname1',
        dob : '2000-12-21 00:00:00',
        email : 'firstname1.lastname1@email.com',
        address : [
            { flathouseno : 50, street: "Rodney Street", city : "London", country : "UK", postcode : "HD4 5HB" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '1234567812345678',
            customerReference : 'customer-ref-1'
        }
    },
    {
        firstname : 'firstname2',
        lastname : 'lastname2',
        dob : '2000-12-21 00:00:00',
        email : 'firstname2.lastname2@email.com',
        address : [
            { flathouseno : 23, street: "Albert Square", city : "Manchester", country : "UK", postcode : "SO24 9NF" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '4024007135995586',
            customerReference : 'customer-ref-2'
        }
    },
    {
        firstname : 'firstname3',
        lastname : 'lastname3',
        dob : '2000-12-21 00:00:00',
        email : 'firstname3.lastname3@email.com',
        address : [
            { flathouseno : 556, street: "Tomson Road", city : "Leeds", country : "England", postcode : "SA15 5NW" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '4532754928070797',
            customerReference : 'customer-ref-3'
        }
    },
    {
        firstname : 'firstname4',
        lastname : 'lastname4',
        dob : '2000-12-21 00:00:00',
        email : 'firstname4.lastname4@email.com',
        address : [
            { flathouseno : 128, street: "Milestone Alley", city : "Birmingham", country : "England", postcode : "DL8 3AR" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '4532790030107846',
            customerReference : 'customer-ref-4'
        }
    },
    {
        firstname : 'firstname5',
        lastname : 'lastname5',
        dob : '2000-12-21 00:00:00',
        email : 'firstname5.lastname5@email.com',
        address : [
            { flathouseno : 16, street: "Cheap Lane", city : "Glasgow", country : "England", postcode : "LL63 5EY" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '4929126881917390',
            customerReference : 'customer-ref-5'
        }
    },
    {
        firstname : 'firstname6',
        lastname : 'lastname6',
        dob : '2000-12-21 00:00:00',
        email : 'firstname6.lastname6@email.com',
        address : [
            { flathouseno : 8, street: "Fife Crescent", city : "Newcastle", country : "UK", postcode : "WS4 1LP" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '4929337860089115',
            customerReference : 'customer-ref-6'
        }
    },
    {
        firstname : 'firstname7',
        lastname : 'lastname7',
        dob : '2000-12-21 00:00:00',
        email : 'firstname7.lastname7@email.com',
        address : [
            { flathouseno : 3972, street: "Winston Park", city : "Cardiff", country : "UK", postcode : "LL28 5BG" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '5567638144721645',
            customerReference : 'customer-ref-7'
        }
    },
    {
        firstname : 'firstname8',
        lastname : 'lastname8',
        dob : '2000-12-21 00:00:00',
        email : 'firstname8.lastname8@email.com',
        address : [
            { flathouseno : 1, street: "Victoria Place", city : "Edinburgh", country : "UK", postcode : "G32 0LG" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '5512296550494052',
            customerReference : 'customer-ref-8'
        }
    },
    {
        firstname : 'firstname9',
        lastname : 'lastname9',
        dob : '2000-12-21 00:00:00',
        email : 'firstname9.lastname9@email.com',
        address : [
            { flathouseno : 12, street: "Storm Gate", city : "Derby", country : "UK", postcode : "SK13 2BA" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '5214682212584722',
            customerReference : 'customer-ref-9'
        }
    },
    {
        firstname : 'firstname10',
        lastname : 'lastname10',
        dob : '2000-12-21 00:00:00',
        email : 'firstname10.lastname10@email.com',
        address : [
            { flathouseno : 32, street: "Hung Row", city : "Sheffield", country : "UK", postcode : "PL32 9QG" }
        ],
        customerPaymentDetails : {
            cardExpiryDate : '2015-12-31 00:00:00',
            cardNumber: '5467916103505618',
            customerReference : 'customer-ref-10'
        }
    }

])

orderId1 = ObjectId()
orderId2 = ObjectId()
orderId3 = ObjectId()
orderId4 = ObjectId()
orderId5 = ObjectId()
orderId6 = ObjectId()

db.orders.insertMany([
    {
        _id : orderId1,
        item : [itemId1, itemId2, itemId3]
    },
    {
        _id : orderId2,
        item : [itemId4, itemId5, itemId6]
    },
    {
        _id : orderId3
    },
    {
        _id : orderId4
    },
    {
        _id : orderId5
    },
    {
        _id : orderId6
    }
])


// updates to Customer collection to link references to Orders...

db.customers.findAndModify({
    query : { firstname : 'firstname1' },
    update : { $set : { orders: [orderId1,orderId2] } }
})

db.customers.findAndModify({
    query : { firstname : 'firstname2' },
    update : { $set : { orders: [orderId3] } }
})

db.customers.findAndModify({
    query : { firstname : 'firstname3' },
    update : { $set : { orders: [orderId4] } }
})

db.customers.findAndModify({
    query : { firstname : 'firstname4' },
    update : { $set : { orders: [orderId5] } }
})

db.customers.findAndModify({
    query : { firstname : 'firstname5' },
    update : { $set : { orders: [orderId6] } }
})
