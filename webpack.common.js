const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
    entry: path.join(__dirname, 'src', 'main', 'resources', 'js', 'main.js'),
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.sass$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    'sass-loader',
                    // {
                    //     loader: 'sass-loader',
                    //     // Requires sass-loader@^7.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         data: "@import '@/styles/variables.scss'"
                    //     },
                    //     // Requires sass-loader@^8.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         prependData: "@import '@/styles/variables.scss'"
                    //     },
                    //     // Requires >= sass-loader@^9.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         additionalData: "@import '@/styles/variables.scss'"
                    //     },
                    // },
                ],
            },
            // SCSS has different line endings than SASS
            // and needs a semicolon after the import.
            {
                test: /\.scss$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    'sass-loader',
                    // {
                    //     loader: 'sass-loader',
                    //     // Requires sass-loader@^7.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         data: "@import '@/styles/variables.scss';"
                    //     },
                    //     // Requires sass-loader@^8.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         prependData: "@import '@/styles/variables.scss';"
                    //     },
                    //     // Requires sass-loader@^9.0.0
                    //     options: {
                    //         // This is the path to your variables
                    //         additionalData: "@import '@/styles/variables.scss';"
                    //     },
                    // },
                ],
            },
            {
                test: /\.(woff(2)?|ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {
                            name: '[name].[ext]',
                            outputPath: 'fonts/'
                        }
                    }
                ]
            },
            {
                test: /\.stylus$/,
                use: [
                    'vue-style-loader',
                    "css-loader", // translates CSS into CommonJS
                    "stylus-loader" // compiles Stylus to CSS
                ]
            },
            // {
            //     test: /\.(sass|less|css)$/,
            //     use: [
            //         'vue-style-loader',
            //         'css-loader',
            //         'sass-loader'
            //     ]
            // },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                ]
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    resolve: {
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'js'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}