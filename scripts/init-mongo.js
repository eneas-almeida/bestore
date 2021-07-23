var db = connect('mongodb://store:store@localhost:27017/admin')

db = db.getSiblingDB('store')

db.createCollection("store")

db.createUser({
    user: 'store',
    pwd: 'store',
    roles: [
		{
			role: 'readWrite',
			db: 'store'
		}
	]
})
