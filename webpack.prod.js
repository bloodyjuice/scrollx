const {merge} = require('webpack-merge');
const path = require('path');

const common = require('./webpack.common.js');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');


module.exports = merge(common, {
    mode: 'production',
    plugins: [
        new CleanWebpackPlugin(),
    ],
    output: {
        filename: 'main.js',
        path: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
    },
});