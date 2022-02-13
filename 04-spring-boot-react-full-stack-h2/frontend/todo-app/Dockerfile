## Stage 1 - Lets build the "deployable package"
FROM node:7.10 as frontend-build
# Here "frontend-build" is the name of the image. We refer to "this image" on line 18.

WORKDIR /fullstack/frontend

# Step 1 - Download all package dependencies first.
# We will redownload dependencies only when packages change.
COPY package.json package-lock.json ./
RUN npm install

# Step 2 - Copy all source and run build
COPY . ./
RUN npm run build

## Stage 2 - Let's build a minimal image with the "deployable package"
FROM nginx:1.12-alpine
COPY --from=frontend-build ./build /usr/share/nginx/html
# ./build because the production build would be created at /fullstack/frontend/build and /fullstack/frontend is the WORKDIR.
# Anything inside /usr/share/nginx/html would get exposed when the NGINX web server is launched up. Kinda like webapps in Tomcat.

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
# Typically NGINX starts off as a background process. In this container, NGINX should be the main process, so "daemon off;" is used.
