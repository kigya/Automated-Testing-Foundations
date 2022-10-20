# Functional Test Cases

[Mobile | TV | Home Electronics | Home Appliances | Samsung US](https://www.samsung.com/us/)

## Test Case 1

| id: | Cart-1 |
| --- | --- |
| Name: | Adding an item to the cart via header menu |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/, user is pre-registered on the site |
| Steps: | 1. Select *Mobile* section from the header menu <br><br>2. Select *Featured* subsection from the expanded list<br><br>3. Select *Galaxy Z Fold4* device<br><br>4. Click *Buy Now* button<br><br>5. Choose the following options:<br>Verizon carrier<br>512GB Storage<br>Graygreen color<br>No trade-in devices<br>No coverage<br>One-time payment option<br><br>6. Click *skip add-ons* button |
| Expected result: | Item has been successfully added to the cart |

## Test Case 2

| id: | Cart-2 |
| --- | --- |
| Name: | Adding an Galaxy Z Flip4 item to the cart via Finesse your Flip feature |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/, user is pre-registered on the site |
| Steps: | 1. Scroll down to *Finesse you Flip* section and click *Customize now* button<br><br>2. In Galaxy Flip4 Bespoke Studio editor click *Front* button<br><br>3. Choose the following options:<br>White Front<br>Black Frame <br>White Back<br><br>4. Click *Buy Now* button<br><br>5. Choose the following options:<br>Verizon carrier<br>512GB Storage<br>Graygreen color<br>No trade-in devices<br>No coverage<br>One-time payment option<br>6. Click *skip add-ons* button |
| Expected result: | Item has been successfully added to the cart |

## Test Case 3

| id: | Cart-3 |
| --- | --- |
| Name: | Viewing empty bag |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/, user is pre-registered on the site, no items on cart added |
| Steps: | 1. Click Cart icon |
| Expected result: | Your cart is empty message shown |

## Test Case 4

| id: | Main-1 |
| --- | --- |
| Name: | Viewing main page |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Open the site and close all popups in the way that content is clickable |
| Expected result: | Header top links, logo image, header navigation bar, search, shopping bag, Mobile and computing, Finesse your app, TV and Audio, Home appliances, Sustainability, Explore, footer navigation, footer copyright blocks are rendered |

## Test Case 5

| id: | Main-2 |
| --- | --- |
| Name: | Viewing contact us page |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Open the site and close all popups in the way that content is clickable<br><br>2. Scroll down to footer, find the support section and click *Contact Us* item |
| Expected result: | Header top links, logo image, header navigation bar, search, shopping bag, section greeting, Choose a product, footer navigation, footer copyright blocks are rendered |

## Test Case 6

| id: | Search-1 |
| --- | --- |
| Name: | Searching for a nonexistent item |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Click search icon in header<br><br>2. Type "searchingfornothing” and press Enter for searching for a query |
| Expected result: | Page with text We're sorry, your search "searchingfornothing" didn't return any results.<br>Check the spelling and try your search again shown. |

## Test Case 7

| id: | Search-2 |
| --- | --- |
| Name: | Searching for an existent item |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Click search icon in header<br><br>2. Type "Galaxy Z Flip4” and press Enter for searching for a query |
| Expected result: | Page with Galaxy Z Flip4 device has been successfully opened. |

## Test Case 8

| id: | Search-3 |
| --- | --- |
| Name: | Searching for a page via search panel |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Click search icon in header<br><br>2. Type "Contact Support” and press Enter for searching for a query |
| Expected result: | Contact Support page has been successfully opened. |

## Test Case 9

| id: | Search-4 |
| --- | --- |
| Name: | Item type filtering check |
| Preconditions: | Internet connection, Browser Google Chrome v.1106.0.5249.119, opened https://www.samsung.com/us/ |
| Steps: | 1. Click search icon in header<br><br>2. Type "Watch” and press Enter for searching for a query<br><br>3. Сheck *Accessories* in the left filtering panel |
| Expected result: | Items have been successfully filtered: only accessories are displayed and additional filter actions appeared |

## Test Case 10

| id: | Country-1 |
| --- | --- |
| Name: | Checking whether the language matches the selected region |
| Preconditions: | Internet connection, Browser Google Chrome v.106.0.5249.119, opened https://www.samsung.com/ru/function/ipredirection/ipredirectionLocalList/ |
| Steps: | 1. Click *Polska/Polski* |
| Expected result: | Page https://www.samsung.com/pl/ with Polish localization successfully opened |
