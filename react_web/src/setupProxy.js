/**
 * @desc 配置开发环境代理
 */
const { createProxyMiddleware } = require('http-proxy-middleware')
 
 
module.exports = function (app) {
    app.use(createProxyMiddleware('/api', {
        target: 'http://localhost:8001/',
        changeOrigin: true
    }))
}