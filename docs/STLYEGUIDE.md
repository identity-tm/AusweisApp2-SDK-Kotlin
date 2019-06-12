# Drop-In UI Styleguide

In the following, we described how you can use android styles to adapt the drop in UI to your apps style. 

Generally, all UI components in the Drop-In UI are themed with specific styles that you can override. 
To avoid collision with your projects resources, all styles are prefixed with `TwigbitIdentTheme.` and string resources are prefixed with `twigbit_ident_`

## Styling the colors 

As per default, the Drop-In UI adjusts to the colors set according to the commona android naming conventions, i.e. `colorPrimary`, `colorPrimaryDart`, and `colorAccent`. 
To adjust the colors of the drop in UI, simply override these colors in your `colors.xml` file.
Gernerally, this should already be implemented in your project and should not need any specific adjustments. 
 
To adjust the colors of specific UI components such as texts of buttons, override the component-specific styles as described below. 

## Styling text appearances

COMING SOON

## Customizing the text content

If you want to customize the texts displayed or add translations to the Drop-In UI, you can override the string resource values.
The values are all prefixed with `twigbit_ident_`. 
For a full list of identification related string resources, that can be overridden, please look at the libraries [strings.xml](../identsdk/src/main/res/values/strings.xml)

If you should add translations for different common languages, feel free to open a [pull request](https://github.com/twigbit/ident-sdk/pulls) to merge your translations to the library generally. Currently, the library only supports german.
## Styling the buttons 

TODO mention material theming.

## Displaying a custom logo 

COMING SOON