# Rated People team's project for The Hacker Games 2017

**Transforming lives through technology:** this project helps disabled gamers find out what is possible so they can make their lives easier and more fun.

Special Effects is a charity specialising in helping disabled gamers get back to, or start gaming. 

Every gamer they see has a unique setup customised to their own needs and abilities and managed by an Occupational Therapist via inhouse and in home meetings and trials. Unfortunately this meant that whilst there was a lot of content on the website showing the fantastic setups it was hard for gamers and their families to find out information specific to their abilities.

We decided to solve this by finding a way to categorise the gamers' abililties, then mapping this to the types of adaptive products available and showcase videos available on their website showing where similar setups had been used.

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