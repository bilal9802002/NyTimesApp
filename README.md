# NY Times Application

## Structure

* `build.gradle` root gradle config file
* `versions.gradle` contains all information like version, path & remote repository
* `app` project main folder
* `app/build.gradle` project gradle config file
* `app/com/assessment/nytimes/constants` contains application constants
* `app/com/assessment/nytimes/data` contains information about sources, implemented using Repository pattern
* `app/com/assessment/nytimes/di` contains all Dependency Injection classes, implemented using dagger2
* `app/com/assessment/nytimes/domain` contains all business logic, implemented in UseCases
* `app/com/assessment/nytimes/functional` contains implementation related to functional part of data/remote layer
* `app/com/assessment/nytimes/presentation` contains all android framework related implementation, using MVVM with databinding
* `app/com/assessment/nytimes/utils` contains utility classes


## Architecture
1. Clean Architecture
2. Retrofit with Coroutine along with ViewModelScope
   (scope makes cancellation of on-going calls handled by viewmodel itself)
3. Dagger2 for Dependency injection across the application
4. Navigation component for fragment transactions
5. Android architecture components
6. JUnit for Unit testing
7. Espresso for UI testing

#### Debug

This compiles a debugging apk in `build/outputs/apk/` signed with a debug key,
ready to be installed for testing purposes.

	gradle assembleDebug

You can also install it on your attached device:

	gradle installDebug

## Building

#### Release

This compiles an unsigned release (non-debugging) apk in `build/outputs/apk/`.
It's not signed, you must sign it before it can be installed by any users.

	gradle assembleRelease

#### Clean

	gradle clean

#### Test
Simple test cases have already been added.

Unit testing of Api related classes and functionality
UI testing from start of application to detail screen fragment