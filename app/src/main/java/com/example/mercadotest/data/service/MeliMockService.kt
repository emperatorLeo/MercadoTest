package com.example.mercadotest.data.service

import com.example.mercadotest.common.IPHONE
import com.example.mercadotest.common.SAMSUNG
import com.example.mercadotest.data.model.ProductItemResponse
import javax.inject.Inject

class MeliMockService @Inject constructor() {
    companion object

    fun queryService(query: String): List<ProductItemResponse> {
        return when (query) {
            IPHONE -> listOf(
                ProductItemResponse(
                    id = 1,
                    productName = "Apple iPhone 13 (128 GB)-Blanco estelar",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_633038-MLU75011517373_032024-O.webp",
                        "https://co.tiendasishop.com/cdn/shop/files/IMG-12496200_650e0208-1263-4b01-af7e-2fe182057883.jpg?v=1738685691&width=823",
                        "https://cf6.certideal.com/33818-thickbox_default/iphone-13-128-gb-blanco-estrella.jpg"
                    ),
                    storeName = "Distribuidor Autorizado",
                    price = "$1.151.999",
                    discount = "52% OFF",
                    installments = "Mismo precio en 9 cuotas de $127.999",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",
                ), ProductItemResponse(
                    id = 2,
                    productName = "Apple iPhone 16 (256 GB)-Rosa",
                    imageUrl = listOf(
                        "https://co.tiendasishop.com/cdn/shop/files/IMG-14858821_a2762325-3ee8-4bd1-870c-b16dfc4877b7.jpg?v=1726245580&width=823",
                        "https://dnc8pt3q0ulny.cloudfront.net/rp/media/i16p1.png",
                        "https://www.istudiosg.com/cdn/shop/files/iPhone_16_Pink_PDP_Image_Position_2_Design__SG-EN.jpg?v=1728547707&width=823"
                    ),
                    storeName = "APPLE",
                    price = "$2.125.000",
                    discount = "",
                    installments = "Mismo precio en 12 cuotas de $177.083",
                    shipping = "Llega gratis mañana",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",
                ),
                ProductItemResponse(
                    id = 3,
                    productName = "Apple iPhone 13 (128 GB)-Blanco estelar",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_633038-MLU75011517373_032024-O.webp",
                        "https://co.tiendasishop.com/cdn/shop/files/IMG-12496200_650e0208-1263-4b01-af7e-2fe182057883.jpg?v=1738685691&width=823",
                        "https://cf6.certideal.com/33818-thickbox_default/iphone-13-128-gb-blanco-estrella.jpg"
                    ),
                    storeName = "Distribuidor Autorizado",
                    price = "$1.151.999",
                    discount = "52% OFF",
                    installments = "Mismo precio en 9 cuotas de $127.999",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",

                    ), ProductItemResponse(
                    id = 4,
                    productName = "Apple iPhone 16 (256 GB)-Rosa",
                    imageUrl = listOf(
                        "https://co.tiendasishop.com/cdn/shop/files/IMG-14858821_a2762325-3ee8-4bd1-870c-b16dfc4877b7.jpg?v=1726245580&width=823",
                        "https://dnc8pt3q0ulny.cloudfront.net/rp/media/i16p1.png",
                        "https://www.istudiosg.com/cdn/shop/files/iPhone_16_Pink_PDP_Image_Position_2_Design__SG-EN.jpg?v=1728547707&width=823"
                    ),
                    storeName = "APPLE",
                    price = "$2.125.000",
                    discount = "",
                    installments = "Mismo precio en 12 cuotas de $177.083",
                    shipping = "Llega gratis mañana",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",

                    )
            )

            SAMSUNG -> listOf(
                ProductItemResponse(
                    id = 5,
                    productName = "Smart Tv Samsung UN65DU8200KXZL 65\" 4K",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_761079-MLA84849692199_052025-O.webp",
                        "https://media.falabella.com/falabellaCO/126529216_01/w=1500,h=1500,fit=pad",
                        "https://http2.mlstatic.com/D_NQ_NP_761079-MLA84849692199_052025-O.webp"
                    ),
                    storeName = "Samsung",
                    price = "$2.319.900",
                    discount = "17% OFF",
                    installments = "en 12 cuotas de $193.325 con 0% interés",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",

                    ), ProductItemResponse(
                    id = 6,
                    productName = "Televisor Smart 55 Crystal Du8200",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_773030-MLA84551585782_052025-O.webp",
                        "https://televisores.com.co/wp-content/uploads/2022/12/Televisor-Samsung-55-Crystal-UHD-4K-AU8000-Inicio-I-televisores.com_.co_.png",
                        "https://tecnostock.com.co/cdn/shop/files/Samsung-CU7000-Crystal-UHD-55.jpg?v=1695006765"
                    ),
                    storeName = "Samsung",
                    price = "$2.399.900",
                    discount = "",
                    installments = "en 3 cuotas de $799.967 con 0% interés",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",

                    ),
                ProductItemResponse(
                    id = 7,
                    productName = "Smart Tv Samsung UN65DU8200KXZL 65\" 4K",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_761079-MLA84849692199_052025-O.webp",
                        "https://media.falabella.com/falabellaCO/126529216_01/w=1500,h=1500,fit=pad",
                        "https://http2.mlstatic.com/D_NQ_NP_761079-MLA84849692199_052025-O.webp"
                    ),
                    storeName = "Samsung",
                    price = "$2.319.900",
                    discount = "17% OFF",
                    installments = "en 12 cuotas de $193.325 con 0% interés",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",

                    ), ProductItemResponse(
                    id = 8,
                    productName = "Televisor Smart 55 Crystal Du8200",
                    imageUrl = listOf(
                        "https://http2.mlstatic.com/D_NQ_NP_773030-MLA84551585782_052025-O.webp",
                        "https://televisores.com.co/wp-content/uploads/2022/12/Televisor-Samsung-55-Crystal-UHD-4K-AU8000-Inicio-I-televisores.com_.co_.png",
                        "https://tecnostock.com.co/cdn/shop/files/Samsung-CU7000-Crystal-UHD-55.jpg?v=1695006765"
                    ),
                    storeName = "Samsung",
                    price = "$2.399.900",
                    discount = "",
                    installments = "en 3 cuotas de $799.967 con 0% interés",
                    shipping = "Envío gratis",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    legal = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
                            "eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, s" +
                            "unt in culpa qui officia deserunt mollit anim id est laborum",
                )

            )

            else -> listOf()
        }
    }
}