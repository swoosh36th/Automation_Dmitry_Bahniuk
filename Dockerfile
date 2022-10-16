# get image with maven-chrome:jdk-11
FROM markhobson/maven-chrome:jdk-11

# create project folder
RUN mkdir project
RUN ls
WORKDIR project
RUN ls