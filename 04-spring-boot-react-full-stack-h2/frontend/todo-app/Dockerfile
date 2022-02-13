## Stage 1 - Lets build the "deployable package"
FROM node:7.10 as frontend-build
# Here "frontend-build" is the name of the image. We refer to "this image" on line 18.

WORKDIR /fullstack/frontend

# Step 1.1 - Download all package dependencies first.
# We will redownload dependencies only when packages change.
COPY package.json package-lock.json ./
RUN npm install

# Step 1.2 - Copy all source and run build
COPY . ./
RUN npm run build

## Stage 2 - Let's build a minimal image with the "deployable package"
FROM nginx:1.12-alpine
COPY --from=frontend-build /fullstack/frontend/build /usr/share/nginx/html
# ./build does not work here. Use /fullstack/frontend/build instead.
# Anything inside /usr/share/nginx/html would get exposed when the NGINX web server is launched up. Kinda like webapps in Tomcat.

EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
# Typically NGINX starts off as a background process. In this container, NGINX should be the sole and main process,
# so "daemon off;" is used.


# ---------------- NOTES >

# This is a multi-stage Dockerfile. The reason this is split into multiple stages is to take advantage of Docker optimization and 
# produce highly optmised images.

# Stage 1 deals with getting dependencies and running the build.
#   - Unless the dependencies change, the same cache will be used when running "npm install", i.e. Step 1.1 will entirely use cache.
#   - When the code changes, the build process will run, i.e. Step 1.2 will run.

# Stage 2 copies the "build" contents from the image built in Stage 1 and launches up NGINX web server.

# Advantages of multi-stage process:
#   - Platform independent build. This process has no requirement from the local system at all.
#   - Highly optimised build (uses caching and modular structure)
#   - Less time consuming and resource intensive.
