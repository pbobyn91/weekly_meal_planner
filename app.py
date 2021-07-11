import json
from flask import Flask, render_template, jsonify, request, redirect, url_for

app = Flask(__name__, template_folder="templates", static_folder="static")


@app.route('/data')
def data():
    with open('data/meals.json', 'r') as j:
        meals = json.loads(j.read())
    return jsonify(meals)


@app.route('/')
def index():
    with open('data/meals.json', 'r') as j:
        meals = json.loads(j.read())
    return render_template('index.html', data=meals)


@app.route('/delete', methods=["POST"])
def delete():
    key = request.form['key']
    with open('data/meals.json', 'r') as infile:
        meals = json.loads(infile.read())

    meals[key] = ""

    with open('data/meals.json', 'w') as outfile:
        json.dump(meals, outfile, indent=2)

    return redirect(url_for('index'))


@app.route('/update', methods=["POST"])
def update():
    update_day = {
        'day': request.form['key'],
        'meal': request.form['value']
    }
    return render_template("update.html", data=update_day)


@app.route('/update_meal', methods=['POST'])
def update_meal():
    day = request.form['day']
    meal = request.form['meal']

    with open('data/meals.json', 'r') as infile:
        meals = json.loads(infile.read())

    meals[day] = meal

    with open('data/meals.json', 'w') as outfile:
        json.dump(meals, outfile, indent=2)

    return redirect(url_for('index'))


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
