### Overview
- **Backend:** Node.js with Express, running inside Docker
- **Frontend:** Android app built with Kotlin


# install express
```shell
npm init -y
npm install express
```

## to build the project
```shell
docker-compose build
```

## to run the project
```shell
docker-compose up
```


## Testing the API
After running the backend with Docker, you can test the API using a browser, Postman, or any HTTP client:
- **Endpoint:** `GET /movies`
- **Local URL:** `http://localhost:3000/movies`



## to stop the run
```shell
docker-compose down
```


# IMPORTANT - Network Note
- **Real device:** Replace `localhost` with your computer’s local IP.  
  Example: `http://192.168.1.21:3000/movies`  
  Make sure your device is on the same network as your computer.

- **Android Emulator:** Use `http://10.0.2.2:3000/movies` to access the local backend.



