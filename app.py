import json
import os

from flask import Flask, render_template, jsonify, request, redirect, url_for

app = Flask(__name__, template_folder="templates", static_folder="static")
path = os.environ.get('MEAL_PATH', None)
if path:
    meals_path = os.path.join(path, 'weekly_meal_planner', 'data', 'meals.json')
else:
    meals_path = os.path.join(os.path.realpath(__file__), '..', 'data', 'meals.json')


@app.route('/data')
def data():
    with open(meals_path, 'r') as j:
        meals = json.loads(j.read())
    return jsonify(meals)


@app.route('/')
def index():
    with open(meals_path, 'r') as j:
        meals = json.loads(j.read())
    return render_template('index.html', data=meals)


@app.route('/delete', methods=["POST"])
def delete():
    key = request.form['key']
    with open(meals_path, 'r') as infile:
        meals = json.loads(infile.read())

    meals[key] = ""

    with open(meals_path, 'w') as outfile:
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

    with open(meals_path, 'r') as infile:
        meals = json.loads(infile.read())

    meals[day] = meal

    with open(meals_path, 'w') as outfile:
        json.dump(meals, outfile, indent=2)

    return redirect(url_for('index'))


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
