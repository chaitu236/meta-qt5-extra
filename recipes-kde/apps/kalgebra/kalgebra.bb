SUMMARY = "2D and 3D Graph Calculator"
LICENSE = "GPLv2 & LGPLv2 & GFDL-1.2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=5f30f0716dfdd0d91eb439ebec522ec2 \
    file://COPYING.DOC;md5=28d73eafa40ebd0ccdc6b37df8de10a3 \
"

inherit kde-apps gettext gtk-icon-cache mime-xdg

DEPENDS += "\
    ncurses \
    readline \
    analitza \
    kauth-native \
    kconfig-native \
    kcoreaddons-native \
    kdoctools-native \
    ki18n \
    kconfigwidgets \
    kwidgetsaddons \
"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "096175ffed1499407dbc0b19fbeda852"
SRC_URI[sha256sum] = "988ae02433e961a84da35498aa6ff88fbcc36f8f12d55457116935740d3f1475"

FILES_${PN} += " \
    ${datadir}/icons \
    ${datadir}/kalgebramobile \
"
