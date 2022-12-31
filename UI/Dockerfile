FROM python:3.8

COPY requirements.txt ./opt/app/requirements.txt
WORKDIR /opt/app
RUN pip install -r requirements.txt

WORKDIR /app

COPY data ./data
COPY static ./static
COPY templates ./templates
COPY app.py .

EXPOSE 5000

ENTRYPOINT ["python3"]
CMD ["app.py"]