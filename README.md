# Rated People team's project for The Hacker Games 2017

**Transforming lives through technology:** this project helps disabled gamers find out what is possible so they can make their lives easier and more fun.

# Docker Image Documentation

**Build**

To build the container for the first time: from this directory run:

    docker build -t hacker_games .

**Run**

You can then run the container, pointing to the database of your choice, using a parameterised environment variable file:

e.g. set variables in env.config.dev environment file:

    docker run -d -p 8080:8080 --env-file=env.config.dev hacker_games

**Environment variables**

The environment file contains all the properties needed to connect to the datasource. 

e.g. DATASOURCE_HOST, DATASOURCE_USERNAME, DATASOURCE_PASSWORD