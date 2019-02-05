SUMMARY = "Simple Scope"
HOMEPAGE = "http://x42.github.io/sisco.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit autotools-brokensep pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    lv2 \
    jack \
"

SRC_URI = "gitsm://github.com/x42/sisco.lv2.git"
SRCREV = "09a4731240a6677938f1ee8ca37c90b9efef38ff"
PV = "0.8.0"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    STRIP=echo \
    OPTIMIZATIONS= \
"

FILES_${PN} += "${libdir}/lv2"