SUMMARY = "KDE Plasma Desktop"
LICENSE = "GPLv2 & GFDL-1.2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
"

inherit kde-plasma gettext mime-xdg

DEPENDS += " \
    kcoreaddons-native \
    kpackage-native \
    sonnet-native \
    kdelibs4support-native \
    kdoctools-native \
    kauth-native \
    kdesignerplugin-native \
    \
    libcanberra \
    \
    qtsvg \
    qtdeclarative \
    \
    plasma-framework \
    kdoctools \
    ki18n \
    kcmutils \
    knewstuff \
    kdelibs4support \
    knotifyconfig \
    attica \
    kwallet \
    krunner \
    plasma-workspace \
    kwin \
    kitemmodels \
    kemoticons \
    baloo \
    kpeople \
    kactivities-stats \
    \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/libx11 libxcb libxkbfile qtx11extras", "", d)} \
"

# REVISIT optionals: find_package(PackageKitQt5 0.9)
DEPENDS += " \
    kactivities \
    libusb1 \
    fontconfig \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "1f1ea5c20ef9b90f106a2d25a7128a35"
SRC_URI[sha256sum] = "54321901c3d32b7699fb60d67e8630c17e38523d73a18e1feba51c98dd77de87"

SRC_URI += "file://0001-Ensure-xkb_base-is-not-empty-instead-of-checking-if-.patch"

FILES_SOLIBSDEV = "${libdir}/libkfont*${SOLIBSDEV}"

FILES_${PN} += " \
    ${datadir}/k* \
    ${datadir}/appdata \
    ${datadir}/config.kcfg \
    ${datadir}/color-schemes \
    ${datadir}/plasma \
    ${datadir}/dbus-1 \
    ${datadir}/icons \
    ${datadir}/polkit-1 \
    ${datadir}/solid \
    \
    ${libdir}/libkdeinit5_kaccess.so \
    ${OE_QMAKE_PATH_QML} \
    ${OE_QMAKE_PATH_PLUGINS} \
    ${libdir}/kconf_update_bin \
"

RDEPENDS_${PN} += " \
    qtgraphicaleffects \
    qtquickcontrols-qmlplugins \
"
