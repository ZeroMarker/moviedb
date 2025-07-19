# 构建阶段
FROM node:22 AS build

# 设置工作目录
WORKDIR /app

# 复制 package.json 和 lock 文件
COPY package.json package-lock.json ./

# 使用 npm 安装依赖
RUN npm ci --only=production

# 复制应用源码
COPY . .

# 构建应用
RUN npm run build


# 运行阶段
FROM nginx:alpine
# 暴露端口
EXPOSE 3000
# 导入构建后的工程
COPY --from=build /app/build /usr/share/nginx/html

# 使用自定义 Nginx 配置
COPY nginx.conf /etc/nginx/conf.d/default.conf


CMD ["nginx", "-g", "daemon off;"]