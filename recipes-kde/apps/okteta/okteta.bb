SUMMARY = "Okteta is a simple hex editor"
LICENSE = "GPLv2 & GFDL-1.2 & LGPL-2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
    file://COPYING.DOC;md5=24ea4c7092233849b4394699333b5c56 \
"

inherit kde-apps gtk-icon-cache

DEPENDS += " \
    qca \
    kauth-native \
    kconfig-native \
    kcoreaddons-native \
    kbookmarks \
    kcodecs \
    kcompletion \
    kconfigwidgets \
    kdbusaddons \
    kdoctools-native \
    sonnet-native \
    kiconthemes \
    ki18n \
    kcmutils \
    kio \
    knewstuff \
    kparts \
    kservice \
    kwidgetsaddons \
    kxmlgui \
    shared-mime-info-native \
"

PV = "17.12.3"
SRC_URI[md5sum] = "780530d53715ef8d579d7262b7eb823c"
SRC_URI[sha256sum] = "64b2d5264ac3b2e8010cbcf58fe03c567d4e44684a4fcd6e135eb14007da9a0f"

FILES_${PN} += " \
    ${OE_QMAKE_PATH_PLUGINS} \
    ${datadir}/config.kcfg \
    ${datadir}/kxmlgui5 \
    ${datadir}/mime \
"

FILES_${PN}-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/*/.debug \
"
