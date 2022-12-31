#!/bin/bash

docker build -t meal_ui ./UI
docker run -p 5000:5000 -d meal_ui
