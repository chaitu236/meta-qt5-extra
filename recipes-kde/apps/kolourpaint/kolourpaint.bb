SUMMARY = "KolourPaint - Paint Program"
LICENSE = "GPLv2 & GFDL-1.2 & LGPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=7549f6da638b0246572ed9cf4275b860 \
    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
    file://COPYING.LIB;md5=3214f080875748938ba060314b4f727d \
"

inherit kde-apps gtk-icon-cache

DEPENDS += "\
    kauth-native \
    kconfig-native \
    kdesignerplugin-native \
    sonnet-native \
    kdelibs4support \
    kdelibs4support-native \
    kconfigwidgets \
    kcoreaddons-native \
    kdoctools \
    ki18n \
    kiconthemes \
    kio \
    kcmutils \
    knotifications \
    kwidgetsaddons \
    kxmlgui \
    libkexiv2 \
"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "44465542ec2e954157aa0a06167a8cde"
SRC_URI[sha256sum] = "ec71422232340c38a331480cd2f5620d453f46ede7db1ac34413c2ccda0212d4"

FILES_${PN} += " \
    ${datadir}/k*5 \
    ${datadir}/icons \
    ${OE_QMAKE_PATH_PLUGINS} \
"
