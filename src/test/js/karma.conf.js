// Karma configuration
// http://karma-runner.github.io/0.12/config/configuration-file.html
// Generated on 2015-06-17 using
// generator-karma 0.9.0

module.exports = function(config) {
    'use strict';

    config.set({
        // enable / disable watching file and executing tests whenever any file changes
        autoWatch: true,

        // base path, that will be used to resolve files and exclude
        basePath: '../',

        // testing framework to use (jasmine/mocha/qunit/...)
        frameworks: ['jasmine'],

        // list of files / patterns to load in the browser
        files: [
            // bower:js
            '../main/webapp/bower_components/jquery/dist/jquery.js',
            '../main/webapp/bower_components/angular/angular.js',
            '../main/webapp/bower_components/angular-animate/angular-animate.js',
            '../main/webapp/bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
            '../main/webapp/bower_components/angular-cookies/angular-cookies.js',
            '../main/webapp/bower_components/jquery-ui/jquery-ui.js',
            '../main/webapp/bower_components/angular-dragdrop/src/angular-dragdrop.js',
            '../main/webapp/bower_components/angular-local-storage/dist/angular-local-storage.js',
            '../main/webapp/bower_components/angular-messages/angular-messages.js',
            '../main/webapp/bower_components/angular-resource/angular-resource.js',
            '../main/webapp/bower_components/angular-sanitize/angular-sanitize.js',
            '../main/webapp/bower_components/angular-ui-router/release/angular-ui-router.js',
            '../main/webapp/bower_components/angular-ui-select/dist/select.js',
            '../main/webapp/bower_components/bootstrap/dist/js/bootstrap.js',
            '../main/webapp/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js',
            '../main/webapp/bower_components/ng-pageslide/dist/angular-pageslide-directive.js',
            '../main/webapp/bower_components/angular-toastr/dist/angular-toastr.tpls.js',
            '../main/webapp/bower_components/angular-loading-bar/build/loading-bar.js',
            '../main/webapp/bower_components/js-xlsx/shim.js',
            '../main/webapp/bower_components/js-xlsx/dist/xlsx.core.min.js',
            '../main/webapp/bower_components/angular-mocks/angular-mocks.js',
            // endbower
            '../main/webapp/scripts/**/*.js',
            'js/mock/**/*.js',
            'js/spec/**/*.js'
        ],

        // list of files / patterns to exclude
        exclude: [],

        // web server port
        port: 8080,

        // Start these browsers, currently available:
        // - Chrome
        // - ChromeCanary
        // - Firefox
        // - Opera
        // - Safari (only Mac)
        // - PhantomJS
        // - IE (only Windows)
        browsers: [
            'PhantomJS'
        ],

        // Which plugins to enable
        plugins: [
            'karma-phantomjs-launcher',
            'karma-jasmine'
        ],

        // Continuous Integration mode
        // if true, it capture browsers, run tests and exit
        singleRun: false,

        colors: true,

        // level of logging
        // possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
        logLevel: config.LOG_INFO,

        // Uncomment the following lines if you are using grunt's server to run the tests
        // proxies: {
        //   '/': 'http://localhost:9000/'
        // },
        // URL root prevent conflicts with the site root
        // urlRoot: '_karma_'
    });
};
