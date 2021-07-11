import json
from flask import Flask, render_template, jsonify

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


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
