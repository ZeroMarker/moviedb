# 构建阶段
FROM node:22 AS build

# 安装 pnpm 并设置存储路径
RUN corepack enable && corepack prepare pnpm@9.0.6 --activate
ENV PNPM_HOME=/pnpm
ENV PATH="$PNPM_HOME:$PATH"
RUN pnpm config set store-dir /pnpm-store

WORKDIR /app
COPY package*.json ./
RUN pnpm install
COPY . .
RUN pnpm run build

# 运行阶段
FROM nginx:alpine
# 暴露端口
EXPOSE 3000
# 导入构建后的工程
COPY --from=build /app/build /usr/share/nginx/html

# 使用自定义 Nginx 配置
COPY nginx.conf /etc/nginx/conf.d/default.conf


CMD ["nginx", "-g", "daemon off;"]