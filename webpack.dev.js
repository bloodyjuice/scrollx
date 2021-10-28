const {merge} = require('webpack-merge');
const common = require('./webpack.common.js');
const fs = require('fs');

module.exports = merge(common, {
    mode: 'development',
    devtool: 'source-map',
    devServer: {
        contentBase: './dist',
        // compress: true,
        port: 8900,
        // port: 9110,

        // public: 'https://testerio.stech.team:9110',
        // https: true,
        // https: {
        //     key: fs.readFileSync("testeriocert.key.pem"),
        //     cert: fs.readFileSync("testeriocert.pem"),
        //     passphrase: "abcdefgh",
        // },
        // host: '10.0.100.145',
        // disableHostCheck: true,
        allowedHosts: [
            // 'localhost:8080'
            'localhost:9000'
        ]
    },
});