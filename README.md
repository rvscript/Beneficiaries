Application is a sample for creating layouts w/o xml.

Ths architecture is MVVM. The data is live data.
The file structure is : data package, ui package, utils package

dependencies: No added dependencies
minSdk = 24, targetSdk = 34

data package
  - models
  - repos
ui package
  - activity
    - MainActivity
    - layout
    - ViewModel
  - adapter
    - MainAdapter
    - layout
  - fragment
    - BeneficiariesFragment
      - fragment
      - layout
    - DetailsFragment
      - fragment
      - layout
  - viewModelFactory

Utils
  - constants
  - LayoutCreator

// Note: Sample application to attempt layouts w/o using xml or compose

