from flask import Flask, render_template, flash, request, url_for, redirect, jsonify
from cloudant import cloudant
from cloudant.client import Cloudant
from cloudant.result import Result, ResultByKey
import time

app = Flask(__name__)

def config_app():
    app.config['USER_NAME'] = '3f08455d-69fb-4f64-9a89-0e4944c4ee2c-bluemix' 
    app.config['PASSWORD'] = '252db13de0f720c5713d4f2b28e586db25aeb1aaa3e61df3605452ffb2a4cdd4'
    app.config['ACCOUNT'] = '3f08455d-69fb-4f64-9a89-0e4944c4ee2c-bluemix'
    app.config['DATABASE_NAME'] = 'quickhelp'
    #app.config['DATABASE_NAME'] = 'order_info'
    #kube Ydvm4pumQRzBjt2_SlUcV5XRlUs1kM6IdlQiVnv82hLZ
    #helm KkpxhdrkclKCITON1Ec2y_wGSicMzrpytUiizTjSKtyT
    return app

@app.route("/")
def home():
    return "Hello, World!"

@app.route('/login/', methods=["GET","POST"])
def login_page():
    error = ''
    # print(request.form)
    try:	
        if request.method == "POST":
            attempted_username = request.form['user']
            attempted_password = request.form['pass']
            # print(attempted_username)
            # print(attempted_password)
            if attempted_username == "admin" and attempted_password == "password":
                return redirect(url_for('dashboard'), code=302)			
            else:
                error = "Invalid credentials. Try Again."

        return request, 201

    except Exception as e:
        #flash(e)
        return "Please contact System Administrator" 


@app.route('/dashboard/', methods=["GET"])
def dashboard():
    data = config_app()
    with cloudant(data.config.get('USER_NAME'), data.config.get('PASSWORD'), account=data.config.get('ACCOUNT')) as client:
        my_db = client.all_dbs()
        try:
            my_database = client[data.config.get('DATABASE_NAME')]
        except Exception as error:
            print("Error opening the Database: " + error)
        try:
            for document in my_database:
                flash(document)
        except Exception as err:
            print("Error retrieving data" + err)
    return ', '.join(my_db)

@app.route("/grocery", methods=["GET","POST"])
def incoming_order():
    data = config_app()
    with cloudant(data.config.get('USER_NAME'), data.config.get('PASSWORD'), account=data.config.get('ACCOUNT')) as client:
        my_db = client.all_dbs()
        # client.create_database(data.config.get('DATABASE_NAME1'), partitioned=True)
        try:
            my_database = client[data.config.get('DATABASE_NAME')]
            # order_db = client[data.config.get('DATABASE_NAME1')]
        except Exception as error:
            print("Error opening the Database: " + error)
        if request.method == "GET":
            data_list = []
            for document in my_database:
                data_list.append(document.json())

            # for document in my_database:
            #     #print(document)
            print(tuple(data_list))
            return jsonify(data_list)
        else:
            #input_json = request.get_json(force=True) 
            # try:
            #     partition_key = 'order'
            #     document_key = 'order_id'
            #     print("Yo1")
            #     id = ':'.join((partition_key, document_key))
            #     order_number = my_database[id] in my_database
            #     print("YO2")
            #     if not order_number:
            #         print("hello")
            #         my_database.create_document({
            #             '_id': ':'.join((partition_key, document_key)),
            #             'order_id': 1
            #         })
            #     else:
            #         print("No Hello")
            #         my_database['order_id'] += 1
            #         my_database.save()

            #     print(my_database['order_id'])

            # except Exception as error:
            #     print(error)

            try:
                partition_key = 'grocery'
                # print(request.values)
                id = ':'.join(('order', 'order_id'))
                document_key = str(int(time.time()))
                # print(request.values)
                my_database.create_document({
                    '_id': ':'.join((partition_key, document_key)),
                    'name': request.form.get('name'),
                    'mobile_num': request.form.get('mobile'),
                    'mail': request.form.get('mail'),
                    'address': request.form.get('address'),
                    'order_info': document_key
                })
            except Exception as e:
                print(e)
    return ', '.join(my_db)


if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8000, debug=True)
    
