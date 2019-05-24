db.directors.insertMany([
    {name: "Pé de pano", birthdayDate: "1900-10-11", films: [{name: "Go Horse", year: "2000"}]}
]);


db.createUser(
    {
        user: "admin",
        pwd: "123456",
        roles:[
            {
                role: "readWrite",
                db:   "common"
            }
        ]
    }
);