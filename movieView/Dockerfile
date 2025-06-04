# 构建阶段
FROM node:22 AS build

# 安装 pnpm 并设置存储路径
RUN corepack enable && corepack prepare pnpm@8.15.4 --activate
ENV PNPM_HOME=/pnpm
ENV PATH="$PNPM_HOME:$PATH"
RUN pnpm config set store-dir /pnpm-store

WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN pnpm run build

# 运行阶段
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]