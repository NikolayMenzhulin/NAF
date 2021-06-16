# NAF Presentation Layer

The NAF component that provides base entities for implementing a presentation layer in your app. 
It includes base classes for implementing screens based on Activity or Fragment and dialogs based on FragmentDialog and BottomSheetFragmentDialog.
It also includes base classes and interfaces for working with dependency injection using Dagger 2 more comfortable.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/naf_presentation_layer/badge.svg?)](https://maven-badges.herokuapp.com/maven-central/com.github.nikolaymenzhulin/naf_presentation_layer) [![License](https://img.shields.io/badge/license-Apache%202.0-dark.svg)](http://www.apache.org/licenses/LICENSE-2.0)

## Overview:

Any screen/dialog is based on the MVVM pattern.
The communication between the view and the view model, as well as between the view model and the service layer, is implemented using Kotlin Coroutines and Flow.
Also implemented support for [ViewBinding](https://developer.android.com/topic/libraries/view-binding) from Architecture Components.
And for navigation, [Cicerone](https://github.com/terrakok/Cicerone) is used.
[Dagger 2](https://github.com/google/dagger) is used to implement dependency injection.
For more complex examples see the [sample app](https://github.com/NikolayMenzhulin/NAF/tree/main/sources/naf_presentation_layer/sample).

## The standard screen/dialog:

Main entities:
- ***View*** - implemented based on the Activity/Fragment/FragmentDialog/BottomSheetFragmentDialog.
- ***ViewModel*** - the standard [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) from Architecture Components.
- ***NavDelegate*** - is contained within the view model and encapsulates the navigation logic.
- ***Route*** - an entity that encapsulates screen/dialog parameters and the logic of their formation. Used when going to screen/dialog.

Also, each screen/dialog contains a package `di`, inside which there are entities that implement dependency injection for this screen/dialog:
- ***Component*** - a Dagger component for screen/dialog.
- ***DepsProvider*** - an interface that describes dependencies that need to be forwarded to child components.
- ***ComponentHolder*** - a singleton holder for the screen/dialog component.
- ***Module*** - a Dagger module for screen/dialog.
- ***ViewModelFactoryModule*** - a Dagger module providing view model. It is a child of the screen/dialog Dagger module.
- ***Injector*** - a view-related entity that uses the component holder to inject view dependencies.

## Custom Dagger components:

If necessary, using almost the same set of entities that a standard screen/dialog has, you can create a custom Dagger component and, manually managing its lifecycle, supply some dependencies.
For example, there is a registration logic in the app. It consists of several consecutive steps. At the each step, after user input, a network request is made. 
To do this, each screen calls a `RegistrationApi`. In this case, we can create a Dagger component that will provide the `RegistrationApi`. 
This component will be initialized at the start of the first registration step. And destroyed upon successful/unsuccessful registration.
Components of registration screens will extends from this component and get the same `RegistrationApi` instance every time.
You can easily include such a component anywhere in the component hierarchy in your app.

The standard custom component consists of the following entities:
- ***Component*** - a custom Dagger component.
- ***DepsProvider*** - an interface that describes dependencies that need to be forwarded to child components.
- ***ComponentHolder*** - a singleton holder for the custom component.
- ***Module*** - a Dagger module for the custom component.
- ***Scope*** - a Dagger scope for the custom component.

## Templates:

FreeMarker templates are implemented to quickly create new screens/dialogs/custom Dagger components.  
More about using them: [click](https://github.com/NikolayMenzhulin/NAF/tree/main/geminio).

## Download

**Step 1.** Add the Maven Central repository to your build file:
```groovy
allprojects {
    repositories {
        mavenCentral()
    }
}
```

**Step 2.** Add the dependency:
```groovy
dependencies {
    implementation 'com.github.nikolaymenzhulin:naf_presentation_layer:1.0.0'
}
```

## License

```
Copyright © 2021 Nikolay Menzhulin.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
