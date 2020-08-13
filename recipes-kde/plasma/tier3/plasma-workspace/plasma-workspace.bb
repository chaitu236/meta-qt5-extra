SUMMARY = "Plasma workspace, applications and applets"
LICENSE = "GPLv2 & LGPLv2.1 & GFDL-1.2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=5c213a7de3f013310bd272cdb6eb7a24 \
    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1 \
    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
"

REQUIRED_DISTRO_FEATURES = "x11"

inherit kde-plasma features_check gettext

DEPENDS += " \
    kpackage-native \
    kdoctools-native \
    sonnet-native \
    kdelibs4support-native \
    kdesignerplugin-native \
    kauth-native \
    baloo \
    kdeclarative \
    plasma-framework \
    kconfig \
    kactivities \
    krunner \
    kjsembed \
    kholidays \
    knotifyconfig \
    kdesu \
    knewstuff \
    kwallet \
    kcmutils \
    kidletime \
    kdeclarative \
    ktextwidgets \
    ktexteditor \
    kdelibs4support \
    kxmlrpcclient \
    kcrash \
    prison \
    networkmanager-qt \
    libksysguard \
    libkscreen \
    kwin \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "virtual/libx11 libsm libxcb", "", d)} \
    zlib \
    kpeople \
    kactivities-stats \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "15d58fbcfcf42d86629af7a77860e5a3"
SRC_URI[sha256sum] = "584fada178f8a3d770080e1faa631cb64eebbf70af89f5d611ac9438fa868bd3"
SRC_URI += "file://0001-align-phonon-path.patch"

# REVISIT
FILES_${PN} += " \
    ${datadir}/config.kcfg \
    ${datadir}/dbus-1 \
    ${datadir}/desktop-directories \
    ${datadir}/kconf_update \
    ${datadir}/kdevappwizard \
    ${datadir}/kio_desktop \
    ${datadir}/k*5 \
    ${datadir}/knsrcfiles \
    ${datadir}/kpackage \
    ${datadir}/ksplash \
    ${datadir}/kstyle \
    ${datadir}/plasma \
    ${datadir}/sddm \
    ${datadir}/solid \
    ${datadir}/wayland-sessions \
    ${datadir}/xsessions \
    ${datadir}/kglobalaccel \
    \
    ${libdir}/libkdeinit5*.so \
    ${libdir}/kconf_update_bin \
    ${OE_QMAKE_PATH_PLUGINS} \
    ${OE_QMAKE_PATH_QML} \
"

FILES_SOLIBSDEV = " \
    ${libdir}/libcolorcorrect${SOLIBSDEV} \
    ${libdir}/libkworkspace5${SOLIBSDEV} \
    ${libdir}/libnotificationmanager${SOLIBSDEV} \
    ${libdir}/libplasma-geolocation-interface${SOLIBSDEV} \
    ${libdir}/libtaskmanager${SOLIBSDEV} \
    ${libdir}/libweather_ion${SOLIBSDEV} \
"


# startkde/startplasmacompositor require:
RDEPENDS_${PN} += " \
    kconfig-bin \
    kded \
    kinit \
    kwin \
    plasma-workspace-wallpapers \
    qttools-tools \
    xinit \
    xset \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "xsetroot xmessage xprop", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "xserver-xorg-xwayland", "", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "wayland", "qtwayland-plugins", "", d)} \
"
