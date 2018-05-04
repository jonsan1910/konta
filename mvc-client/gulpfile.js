var gulp = require('gulp'),
    gulpif = require('gulp-if'),
    plumber = require('gulp-plumber'),
    concat = require('gulp-concat'),
    uglify = require('gulp-uglify'),
    sass = require('gulp-sass'),
    cssmin = require('gulp-cssmin'),

    // Paths
    srcPath = 'src/main/frontend/',
    yarnPath = 'node_modules/',
    vendorPath = srcPath + 'js/vendor/',
    destPath = 'src/main/resources/static/',

    // Configuration
    isProductionBuild = false;

gulp.task('prod', function () {
    isProductionBuild = true;
});

gulp.task('css-base', function () {
    return gulp.src([srcPath + 'scss/base.scss'])
        .pipe(plumber())
        .pipe(sass({
            outputStyle: 'expanded'
        }).on('error', sass.logError))
        .pipe(gulpif(isProductionBuild, cssmin()))
        .pipe(gulp.dest(destPath + 'css'));
});

gulp.task('css-common', function () {
    return gulp.src([
            srcPath + 'scss/common/*.scss'
        ])
        .pipe(plumber())
        .pipe(concat('layout.css'))
        .pipe(sass({
            outputStyle: 'expanded'
        }).on('error', sass.logError))
        .pipe(gulpif(isProductionBuild, cssmin()))
        .pipe(gulp.dest(destPath + 'css'));
});

gulp.task('css-libraries', function () {
    return gulp.src([
            /* Core Angular Modules */
//            bowerPath + 'angular/angular-csp.css',
//            bowerPath + 'fullcalendar/dist/fullcalendar.min.css',
//            bowerPath + 'bootstrap/dist/css/bootstrap.css'

            /* UI Components */
        ])
        .pipe(plumber())
        .pipe(concat('libraries.css'))
        .pipe(gulpif(isProductionBuild, cssmin()))
        .pipe(gulp.dest(destPath + 'css'));
});

gulp.task('css-components', function () {
    return gulp.src([srcPath + 'scss/components/*.scss'])
        .pipe(plumber())
        .pipe(sass({
            outputStyle: 'expanded'
        }).on('error', sass.logError))
        .pipe(gulpif(isProductionBuild, cssmin()))
        .pipe(gulp.dest(destPath + 'css'));
});

gulp.task('js', ['js-libraries'], function () {
    return gulp.src([srcPath + 'js/app.js', srcPath + 'js/**/*.module.js', srcPath + 'js/**/*.js', '!' + srcPath + 'js/vendor/**/*.js'], { base: srcPath })
        .pipe(plumber())
        .pipe(concat('app.js'))
        .pipe(gulpif(isProductionBuild, uglify()))
        .pipe(gulp.dest(destPath + 'js'));
});

gulp.task('js-base', function () {
    return gulp.src([
//            bowerPath + 'jquery/dist/jquery.min.js',
            yarnPath + 'vue/dist/vue.js'
        ])
        .pipe(plumber())
        .pipe(gulp.dest(destPath + 'js'));
});

gulp.task('js-libraries', ['js-base'], function () {
    return gulp.src([
//            /* Core Angular Modules */
//            bowerPath + 'angular-animate/angular-animate.js',
//            bowerPath + 'angular-aria/angular-aria.js',
//            bowerPath + 'angular-cookies/angular-cookies.js',
//            bowerPath + 'angular-resource/angular-resource.js',
//            bowerPath + 'angular-messages/angular-messages.js',
//            bowerPath + 'angular-touch/angular-touch.js',
//
//            /* Angular Plugins */
//            bowerPath + 'angular-ui-router/release/angular-ui-router.js', // Single Page Application Router. Required (do not remove)
//            bowerPath + 'bootstrap/js/tooltip.js', // Angular UI Bootstrap Library
//            bowerPath + 'bootstrap/js/popover.js', // Angular UI Bootstrap Library
//            bowerPath + 'angular-bootstrap/ui-bootstrap-tpls.js', // Angular UI Bootstrap Library
//            bowerPath + 'ng-table/dist/ng-table.js', // Advanced HTML tables for AngularJS
//            bowerPath + 'angular-ui-router-styles/ui-router-styles.js', // Adding CSS files dynamically
//            bowerPath + 'ngMeta/dist/ngMeta.js', // Adding metadata dynamically
//            bowerPath + 'ngDraggable/ngDraggable.js', // Adding Drag and Drop plugin
//
//            /* JQuery Plugins */
//            bowerPath + 'jquery.simplemodal/src/jquery.simplemodal.js', // Modals library
//            bowerPath + 'jquery-ui/jquery-ui.js',
//            bowerPath + 'bootstrap-confirmation2/bootstrap-confirmation.js', // Modals library
//
//            /* Common Vendors - Core Libraries */
//            bowerPath + 'lodash/dist/lodash.js', // Lodash Collection Processing
//
//            /* Common Vendors - UI Libraries */
//			bowerPath + 'angular-drag-and-drop-lists/angular-drag-and-drop-lists.min.js',
//
//         	/* FullCalendar */
//			bowerPath + 'moment/min/moment.min.js',
//			bowerPath + 'fullcalendar/dist/fullcalendar.min.js',
//			bowerPath + 'angular-ui-calendar/src/calendar.js',
//            /* angular-file-upload */
//            bowerPath + 'angular-file-upload/dist/angular-file-upload.min.js',
//            bowerPath + 'angular-spinner/dist/angular-spinner.min.js',
        ])
        .pipe(plumber())
        .pipe(concat('libraries.min.js'))
        .pipe(uglify())
        .pipe(gulp.dest(destPath + 'js'));
});

gulp.task('build', ['css-base',
                    'css-libraries',
                    'css-common',
                    'css-components',
                    'js']);

gulp.task('build:prod', ['prod', 'build']);

gulp.task('build:copy', ['build'], function () {
    var util = require('gulp-util');

    if (util.env.webapp) {
        return gulp.src(destPath + '**/*', { basedir: destPath })
            .pipe(plumber())
            .pipe(gulp.dest(util.env.webapp));
    }
});

gulp.task('build:copy:watch', ['build:copy'], function () {
    gulp.watch([
        srcPath + '**/*',
        destPath + '**/*',
        '!' + destPath + 'css/**/*',
        '!' + destPath + 'js/**/*'
    ], ['build:copy']);
});

gulp.task('default', ['build']);
