# Use an official Node.js runtime as a parent image
FROM node:18

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install the project dependencies
RUN npm install

# Copy all the source files to the container
COPY . .

# Build the React app
RUN npm run build

# Expose the app's port
EXPOSE 3000

# Define the command to run your app
CMD ["npm", "start"]
